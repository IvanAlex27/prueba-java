package gitprueba;

/**
 *
 * @author iacarrasco
 */
public class Excepcion extends RuntimeException {

    private static final long serialVersionUID = 8417371725068210038L;

    private final Excepcion.CAUSE cause;

    private final String message;

    /**
     *
     */
    public enum CAUSE {

        /**
         * Un objeto con el id y/o las caracteristicas indicadas ya existe en el
         * sistema.
         */
        OBJETO_EXISTENTE,
        /**
         * Un objeto con el id y/o o las caracteristicas indicadas no existe en
         * el sistema.
         */
        OBJETO_NO_EXISTENTE,
        /**
         * El objeto no es modificable, de acuerdo a invariantes del sistema..
         */
        OBJETO_NO_MODIFICABLE,
        /**
         * No se pude realizar la transacción para obtener o modificar los
         * objetos en el sistema.
         */
        TRANSACCION_FALLIDA,
        /**
         * No se pude realizar la operacion. Revisar la causa para mayor
         * información.
         */
        OPERACION_INCONCLUSA,
        /**
         * No se pude realizar la operacion porque viola una o más reglas de
         * negocio.
         */
        VIOLACION_REGLA_NEGOCIO;
    }

    public Excepcion() {
        super();
        this.cause = CAUSE.OPERACION_INCONCLUSA;
        this.message = "";
    }

    /**
     *
     * @param cause
     */
    public Excepcion(CAUSE cause) {
        super(cause.toString());
        this.cause = cause;
        this.message = cause.toString();
    }

    /**
     *
     * @param throwable
     */
    public Excepcion(Throwable throwable) {
        super(throwable);
        this.cause = CAUSE.OPERACION_INCONCLUSA;
        this.message = throwable.getMessage();
    }

    /**
     *
     * @param cause
     * @param message
     */
    public Excepcion(CAUSE cause, String message) {
        super(String.join("::", cause.toString(), message));
        this.cause = cause;
        this.message = message;
    }

    /**
     *
     * @param causeT
     * @param cause
     * @param message
     */
    public Excepcion(Throwable causeT, CAUSE cause, String message) {
        super(String.join("::", cause.toString(), message), causeT);
        this.cause = cause;
        this.message = message;
    }

    /**
     *
     * @param throwable
     * @param cause
     */
    public Excepcion(Throwable throwable, CAUSE cause) {
        super(cause.toString(), throwable);
        this.cause = cause;
        this.message = cause.toString();
    }

    /**
     *
     * @return CAUSE
     */
    public CAUSE getCauseBy() {
        return cause;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
