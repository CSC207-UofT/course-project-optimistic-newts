package adapters;

import application.OutputBoundary;
import application.ResponseModel;

public class CliPresenter implements OutputBoundary {
    private final InOut inOut;

    /**
     * Creates a new CliPresenter with an InOut location.
     * @param inOut object to send output by
     */
    public CliPresenter(InOut inOut) {
        this.inOut = inOut;
    }

    /**
     * Sends a response to this presenter's output location.
     * @param response   a response stored as a ResponseModel
     */
    @Override
    public void respond(ResponseModel response) {

    }

    /**
     * Sends a String to be output by this presenter's output object.
     * @param toPresent String to be output
     */
    public void present(String toPresent) {
        inOut.sendOutput(toPresent);
    }
}
