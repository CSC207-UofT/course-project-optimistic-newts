package adapters;

import application.OutputBoundary;
import application.ResponseModel;

public class TestPresenter implements OutputBoundary {

    /**
     * @param response a response stored as a ResponseModel
     */
    @Override
    public void response(ResponseModel response) {
        ResponseModel r = response;
    }
}
