package org.nttdata.javat1;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Clase principal que almacena los puntos (score), la bola (que está en juego),
 * contador de bolas extras (extraBallCounter), la máxima puntuación,
 * el atributo Playfield con los parámetros del juego (Items) que contendrá
 * el tablero de juego que se extraen de una BD y sus reglas y misiones
 * <p>
 * Inicializa una GUI con el menú
 * Mantendrá el juego activo subiendo puntos según Ítems y misiones alcanzadas y finalizará con
 * el atributo estático lostBall del Objeto Ball sea true y además no existan bolas extras
 * <p>
 * Se establece con rules, los ítems que se necesita para bola extra y premio jackpot
 * <p>
 * Se alcanza bola extra cuando la bola ha estado en x reboteadores + x combos
 * se activará extraballavailable en los agujeros de salida laterales,
 * si la bola los alcanzará se sumará una bola extra
 * <p>
 * Se alcanza un bote de puntos (jackpot) para una bola que ha alcanzado x dianas y x combos
 * establecidas las variables como final para x veces (counters, reached...)
 * <p>
 * Si se alcanza un nuevo récord, se guardará en la base de datos, junto a las iniciales del jugador
 *
 * @author Isabel Pastor López
 * @version 1.0
 * @see <a href="https://pinballvirtual.es/diccionario-pinball-virtual/">Diccionario Pinball Virtual</a>
 */
public class T1MainIPL {
    private static final Logger LOGG = LoggerFactory.getLogger(T1MainIPL.class);
    /**
     * The constant score (puntuación)
     */
    protected static Integer score = 0;
    /**
     * The constant maxScore (récord)
     */
    protected static Integer maxScore = 0;
    /**
     * The constant extraBallCounter (contador de bolas extras)
     */
    protected static Integer extraBallCounter = 0;

    /**
     * *********************************************
     * REGLAS DEL JUEGO (BOLA EXTRA Y JACKPOT)
     */
// para lograr bola extra
        protected static Integer counterSlingshots = 0;

    /**
     * The constant REACHSLINGSHOTS.
     */
    protected static final Integer REACHSLINGSHOTS = 50;

        // para lograr jackpot
    /**
     * The constant counterCombos.
     */
    protected static Integer counterCombos = 0;

    /**
     * The constant REACHCOMBOS.
     */
    protected static final Integer REACHCOMBOS = 9;

    /**
     * The constant counterTargets.
     */
    protected static Integer counterTargets = 0;

    /**
     * The constant REACHTARGETS.
     */
    protected static final Integer REACHTARGETS = 15;

    // premio jackpot
    /**
     * The constant JACKPOT.
     */
    protected static final Integer JACKPOT = 15000;

    // bonus por alcanzar el máximo de un pasillo o rampa
    /**
     * The constant BONUSCOMBO.
     */
    protected  static final Integer BONUSCOMBO = 500;

    /**
     * *********************************************
     * MÉTODO PRINCIPAL
     *
     * @param args the input arguments
     * @throws SQLException the sql exception
     */
    public static void main(String[] args) throws SQLException {
        LOGG.info("Inicio declaración de variables");

        // Cargar tablero de juego de la Base de Datos
        PlayField playField = buildPlayField();

        // Crea la bola
        Ball ball = new Ball();

        // Variable para escanear entradas de teclado
        Scanner sc = new Scanner(System.in);
        int select;

        // Variable para salir del bucle menú
        boolean start = false;

        // Crear variable GUI nula
        GUI gui = null;

        LOGG.info("Inicio del bucle start");
        // hasta que el usuario lance la bola
        while (!start ){

            // inicializar GUI y mostrar menu
            gui = new GUI() ;

            // recoger entrada por teclado
            boolean continua;
            do {
                LOGG.info("Inicio del bucle continua");
                try { // tratar posibles excepciones
                    continua = false;
                    gui.menu();
                    select = sc.nextInt();

                    if (select == 1) { // Insertar moneda
                        extraBall(); // muestra mensaje y suma bola extra

                    } else if (select == 2) { // Comenzar
                        start = true;

                    } else { // cualquier otra entrada no válida
                        System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡ OPCIÓN NO DISPONIBLE !!!!!!!!!!!!");
                        gui.menu(); // muestra menú
                    }
                } catch (InputMismatchException ex) {
                    LOGG.debug("capturada excepción, entrada por teclado inesperada");
                    System.out.println("Debe teclear opción 1 u opción 2");
                    sc.next();
                    continua = true;
                }
            } while (continua);
            LOGG.info("Salida del bucle continua");
        }
        LOGG.info("Salida del bucle start");

        LOGG.info("Inicio del bucle extraBallCounter");
        while(extraBallCounter > 0){ // mientras queden bolas extras
            LOGG.info("Inicio del bucle isLostBall");
            while(!Ball.isLostBall()) { // mientras la bola no caiga en un agujero
                // la bola se encuentra en la rampa de salida

                // Ir a un Ítem aleatorio (excepto a la rampa de salida que es posición 0 (inalcanzable))
               ball.setPosition(goTo(playField));

               // Dónde se encuentra la bola ahora
               Item itemActual = ball.getPosition();

               // Si el ítem actual va hacia una maneja, comienza el usuario a manejar
                itemActual = isFlipper(itemActual);

                // si el ítem actual es un reboteador, contará para bonus
                isSlingshot(playField, itemActual);

                // si el ítem actual es una rampa o pasillo, contará para bonus y/o Jackpot
                isCombo(itemActual);

                //  si el ítem acutal es diana contará para Jackpot
                isTarget(gui, itemActual);

                // Suma los puntos al score
               scorePoints(itemActual.getPoints());

               // Muestra los detalles del movimiento en pantalla
               itemActual.showInfo();

               // si el ítem actual es un agujero, se pierde bola y abre otras opciones
                esAgujero(itemActual);
            }
            LOGG.info("Salida del bucle isLostBall");
            extraBallCounter--; // si ha salido del bucle anterior, se resta la bola perdida
            Ball.setLostBall(false); // resetear la bola a NO perdida
        }
        LOGG.info("Salida del bucle extraBallCounter");
        // mostrar por pantalla que se ha acabado la partida
        gui.gameOver();

        saveScore(gui);
        LOGG.info("Guardado");
        // cerrar la conexión al finalizar la aplicación
        BBDDConnection.closeConnection();
        LOGG.info("Cerrada conexión a base de datos");
    }

    private static void saveScore(GUI gui) {
        // si hay récord, guardar datos del usuario y puntos en la base de datos
        if (Objects.equals(maxScore, score)){

            // cargar conexion
            Connection connection = BBDDConnection.getConnection();
            try{
                connection.setAutoCommit(false); // no hacer autocommit
                gui.record();
                // salvar el récord en la base de datos
                saveRecord();
                connection.commit(); // hacer commit
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                try {
                    if(connection != null){ // si no se ha podido establecer la conexión, hacer rollback
                        connection.rollback();
                        System.out.println("================== Rollback realizado ===================");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        } else {
            gui.result();
        }
    }

    private static void esAgujero(Item itemActual) {
        // si la bola cae en un agujero
        if(itemActual instanceof OutHole){
            // comprueba si tiene la opción de bola extra "encendida"
            if (isAvailableExtraBall(itemActual)) {
                extraBall(); // suma bola extra
                ((OutHole) itemActual).availableExtraBall(false); // deja de estar "encendido" bola extra
                Ball.setLostBall(true); // se ha perdido la bola
            }
        } else if(itemActual instanceof SkinHole) { // si ha caído en un agujero a otra dimensión de juego
            // comienza ruleta (bonus puntos extra)
            scorePoints( ((SkinHole) itemActual).roulette() );
        }
    }

    private static void isTarget(GUI gui, Item itemActual) {
        // Si el ítem actual es una instancia de Target (diana)
        if (itemActual instanceof Target){
            counterTargets++;
        }
        // si se han alcanzado las dos condiciones para jackpot
        if(REACHCOMBOS <= counterCombos && REACHTARGETS <= counterTargets){
            counterCombos -= REACHCOMBOS;
            counterTargets -= REACHTARGETS;
            scorePoints(JACKPOT);
            gui.jackpot(JACKPOT);
        }
    }

    private static void isCombo(Item itemActual) {
        ///// ALCANZAR JACKPOT
        // Si el ítem actual es instancia de Combo (rampa o pasillo)
        if (itemActual instanceof Combo){
            if (Objects.equals(((Combo) itemActual).getClimb(), ((Combo) itemActual).getUntil())){
                // Se ha alcanzado el máximo de la rampa, bonus rampa
                scorePoints(BONUSCOMBO);
            }
            counterCombos++; // cuenta para alcanzar objetivo de jackpot
        }
    }

    private static void isSlingshot(PlayField playField, Item itemActual) {
        // Si el ítem actual es instancia de Rebounder (rebota)
        if ( itemActual instanceof Rebounder){
            scorePoints(((Rebounder) itemActual).Bounce()); // suma puntos de los rebotes

            // contador de reboteadores (Slingshots)
            counterSlingshots++;
            if(REACHSLINGSHOTS <= counterSlingshots) { // alcanzado objetivo --> bola extra
                setAvailableExtraBall(playField);
                counterSlingshots -= REACHSLINGSHOTS;
            }
        }
    }

    private static Item isFlipper(Item itemActual) {
        // Si está en una maneja
        if (itemActual instanceof Flipper) {
            // si acierta pulsando la maneja correcta, continuará el juego, si no, irá al agujero del centro
           itemActual = manejar((Flipper) itemActual);
        }
        return itemActual;
    }

    /**
     * Guarda el récord junto a las iniciales del jugador en la base de datos
     */
    private static void saveRecord() {
        // Solicita al usuario por pantalla las iniciales de su nombre
        System.out.println(" ==== INTRODUCE LAS INICIALES DE TU NOMBRE ====");
        String iniciales = new Scanner(System.in).nextLine();
        Connection connection = BBDDConnection.getConnection();
        try {
            // realiza una consulta para insertar campos
            String consultaSQL = "INSERT INTO max_score VALUES(?,?)";
            PreparedStatement ps = connection.prepareStatement(consultaSQL);

            ps.setString(1, iniciales);
            ps.setInt(2, score);

            ps.execute();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    /**
     * Pide al usuario que elija manejador derecho o izquierdo, si acierta, la bola sigue,
     * si falla, su próximo ítem será el agujero central
     * @param flipper Flipper
     */
    private static Item manejar(Flipper flipper) {

        Item itemReturn;

        Scanner sc = new Scanner(System.in);
        String info = "¡¡¡¡¡ La bola se dirige a un agujero !!!!! "
                        .concat("\n")
                        .concat("Pulsa la tecla a para manejar la paleta izquierda o d para la paleta derecha");
        System.out.println(info);
        String sr = sc.nextLine();

        // si mueve la paleta izquierda
        if ( sr.startsWith("a") || sr.startsWith("A") ){

            // si la bola iba dirección a la paleta izquierda
            if (flipper.getId().equals("leftFlipper")){
                System.out.println("¡Buen golpe!, ¡has salvado la bola!");
                itemReturn = flipper;

            } else { // si no ha acertado, la bola irá al agujero del centro
                itemReturn = new OutHole("Agujero del centro");
            }

            // si mueve la paleta derecha
        } else if ( sr.startsWith("d") || sr.startsWith("D") ) {

            // si la bola iba dirección a la paleta derecha
            if (flipper.getId().equals("rightFlipper")){
                System.out.println("¡Buen golpe!, ¡has salvado la bola!");
                itemReturn = flipper;

            }   else { // si no ha acertado, la bola irá al agujero del centro
                itemReturn = new OutHole("Agujero del centro");
            }
        } else { // si no introduce las teclas del manejo de la maneta, la bola irá al agujero del centro
            System.out.println("¡¡ Has fallado !!");
            itemReturn = new OutHole("Agujero del centro");
        }
        return itemReturn;
    }

    /**
     * Genera una bola extra y muestra un mensaje informando del evento
     */
    private static void extraBall() {
        extraBallCounter++;
        System.out.println("¡¡ EXTRA BALL !!");
    }

    /**
     * Crea un tablero de juego (PlayField) con todos los ítems que recoge de una BD
     * @return PlayField
     */
    private static PlayField buildPlayField() throws SQLException {
        System.out.println("Cargando tablero....");
        PlayField playField = new PlayField();
        // Establecer conexión con la BD PlayField
        Connection connection = BBDDConnection.getConnection();

        chargePlayField(playField, connection);

        System.out.println();
        return playField;
        }

    private static void chargePlayField(PlayField playField, Connection connection) throws SQLException {
        chargeCombos(playField, connection);

        chargeSkinholes(playField, connection);

        chargeSlingShots(playField, connection);

        chargeTargets(playField, connection);

        chargeMaxScore(connection);
    }

    private static void chargeCombos(PlayField playField, Connection connection) throws SQLException {
        ///////// CARGAR COMBOS /////////
        System.out.println("Cargando rampas....");
        // Texto de la consulta a la bd
        String consulta = "SELECT * FROM combos;";
        PreparedStatement ps = connection.prepareStatement(consulta);
        // Guarda el resultado de la consulta en un conjunto (ResultSet)
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Combo combo = new Combo(
                    rs.getString(1),
                    rs.getInt(2),
                    rs.getInt(3)
            );
            playField.addItem(combo);
        }
    }

    private static void chargeSkinholes(PlayField playField, Connection connection) throws SQLException {
        ///////// CARGAR SKINHOLES /////////
        System.out.println("Cargando agujeros a otra dimensión....");
        // Texto de la consulta a la bd
        String consulta1 = "SELECT * FROM skinhole;";
        PreparedStatement ps1 = connection.prepareStatement(consulta1);
        // Guarda el resultado de la consulta en un conjunto (ResultSet)
        ResultSet rs1 = ps1.executeQuery();
        while (rs1.next()) {
            SkinHole skinhole = new SkinHole(
                    rs1.getString(1),
                    rs1.getInt(2)
            );
            playField.addItem(skinhole);
        }
    }

    private static void chargeSlingShots(PlayField playField, Connection connection) throws SQLException {
        ///////// CARGAR SLINGSHOTS /////////
        System.out.println("Cargando manejas....");
        // Texto de la consulta a la bd
        String consulta2 = "SELECT * FROM slingshot;";
        PreparedStatement ps2 = connection.prepareStatement(consulta2);
        // Guarda el resultado de la consulta en un conjunto (ResultSet)
        ResultSet rs2 = ps2.executeQuery();
        while (rs2.next()) {
            Slingshot slingshot = new Slingshot(
                    rs2.getString(1),
                    rs2.getInt(2),
                    rs2.getInt(3)
            );
            playField.addItem(slingshot);
        }
    }

    private static void chargeMaxScore(Connection connection) throws SQLException {
        ///////// CARGAR MAX_SCORE /////////
        System.out.println("Cargando récord de puntuación....");
        // Texto de la consulta a la bd
        String consulta4= "SELECT MAX(score) FROM max_score";
        PreparedStatement ps4 = connection.prepareStatement(consulta4);
        // Guarda el resultado de la consulta en un conjunto (ResultSet)
        ResultSet rs4 = ps4.executeQuery();
        while (rs4.next()) {
            maxScore = rs4.getInt(1);
        }
    }

    private static void chargeTargets(PlayField playField, Connection connection) throws SQLException {
        ///////// CARGAR TARGETS /////////
        System.out.println("Cargando dianas....");
        // Texto de la consulta a la bd
        String consulta3 = "SELECT * FROM targets;";
        PreparedStatement ps3 = connection.prepareStatement(consulta3);
        // Guarda el resultado de la consulta en un conjunto (ResultSet)
        ResultSet rs3 = ps3.executeQuery();
        while (rs3.next()) {
            Target t = new Target(
                    rs3.getString(1),
                    rs3.getInt(2)
            );
            playField.addItem(t);
        }
    }


    /**
     * Score points.
     * suma puntos al atributo score
     * Si la puntuación actual (score) supera el récord (maxScore), entonces
     * maxScore será igual a la puntuación actual
     *
     * @param points the points
     */
    public static void scorePoints(Integer points){
        score += points;
        maxScore = maxScore<score ? score : maxScore;
    }

    /**
     * Método que devuelve un número aleatorio entre un rango dado
     *
     * @param max int
     * @param min int
     * @return número aleatorio Integer
     */
    public static Integer random(int max, int min){
        return new Random().nextInt((max - min) + 1) + min;
    }

    /**
     * Go to item.
     *
     * @param playField PlayField
     * @return Ítem aleatorio de la lista de Ítems inicializados en el tablero de juego
     */
    public static Item goTo(PlayField playField){

        int max = playField.getItems().size() -1;
        // nos saltamos la posición 0, porque es el primer registro en el que se encuentra la rampa de salida
        int min = 1;

        return playField.getItems().get(random(max, min));
    }


    /**
     * Establece extra ball para los agujeros laterales
     *
     * @param playField the play field
     */
    public static void setAvailableExtraBall(PlayField playField){
        for (Item item: playField.getItems()
             ) {
            // si es un agujero lateral
            if ( (item.getId().equals("Agujero de la izquierda")
                    || item.getId().equals("Agujero de la derecha") )
                    && item instanceof OutHole) {
                ((OutHole) item).availableExtraBall(true);
            }
        }
    }

    /**
     * Is available extra ball boolean.
     *
     * @param item the item
     * @return the boolean
     */
    public static boolean isAvailableExtraBall(Item item){
        if (item instanceof OutHole) {
            return ((OutHole) item).isExtraBall();
        }
        return false;
    }
}
