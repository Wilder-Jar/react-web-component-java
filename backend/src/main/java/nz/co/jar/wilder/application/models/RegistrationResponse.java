package nz.co.jar.wilder.application.models;

public class RegistrationResponse {

    private boolean success;
    private String type;
    private String message;

    public RegistrationResponse(boolean success, String type, String message) {
        this.success = success;
        this.type = type;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
