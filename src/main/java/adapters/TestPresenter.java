package adapters;

import application.OutputBoundary;
import application.ResponseModel;

public class TestPresenter implements OutputBoundary {

    /**
     * @param response a response stored as a ResponseModel
     */
    @Override
    public void respond(ResponseModel response) {
        ResponseModel r = response;
    }
}
