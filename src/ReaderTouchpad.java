public class ReaderTouchpad extends Reader {

    private Touchpad touchpad;

    public ReaderTouchpad(IrisScanner scanner, FingerprintScanner fingerprintScanner,
                          Touchpad touchpad){
        super(scanner, fingerprintScanner);
        this.touchpad = touchpad;
    }

    public String setPassword(String password) {
        touchpad.setInput(password);
        return touchpad.getInput();
    }

    public Touchpad getTouchpad() {
        return touchpad;
    }

    public void setTouchpad(Touchpad touchpad) {
        this.touchpad = touchpad;
    }
}
