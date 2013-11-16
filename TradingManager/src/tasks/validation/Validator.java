package tasks.validation;

import domain.model.client.ClientRequest;

public interface Validator<T extends ClientRequest> {

	void validate(T order);

}
