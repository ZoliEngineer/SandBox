package converter;

import domain.model.OrderEvent;

public interface Converter<I extends OrderEvent, O extends OrderEvent> {
	O convert(I i);
}
