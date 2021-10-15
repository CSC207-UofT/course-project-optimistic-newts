package adapters;

import application.OutputBoundary;
import application.ResponseModel;

public class CliPresenter implements OutputBoundary {
    private final InOut inOut;

    public CliPresenter(InOut inOut) {
        this.inOut = inOut;
    }

    @Override
    public void response(ResponseModel response) {
        for (Object value : response.getData().values()) {
            present(value.toString());
        }
    }

    public void present(String toPresent) {
        inOut.sendOutput(toPresent);
    }
}
