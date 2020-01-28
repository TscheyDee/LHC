public class ReaderTouchpad extends Reader {

    private Touchpad touchpad;

    public ReaderTouchpad(IrisScanner scanner, IDCard idCard, IReaderTechnology iReaderTechnology, Touchpad touchpad){
        super(scanner, idCard, iReaderTechnology);
        this.touchpad = touchpad;
    }

    public String enterPIN() {
        return touchpad.getInput();
    }

    public Touchpad getTouchpad() {
        return touchpad;
    }

    public void setTouchpad(Touchpad touchpad) {
        this.touchpad = touchpad;
    }
}
