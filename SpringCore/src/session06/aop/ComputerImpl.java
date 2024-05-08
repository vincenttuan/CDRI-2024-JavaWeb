package session06.aop;

import org.springframework.stereotype.Component;

@Component("computerImpl")
public class ComputerImpl implements Computer {

	@Override
	public Integer add(Integer x, Integer y) {
		return x + y;
	}

	@Override
	public Integer sub(Integer x, Integer y) {
		return x - y;
	}

	@Override
	public Integer mul(Integer x, Integer y) {
		return x * y;
	}

	@Override
	public Integer div(Integer x, Integer y) {
		return x / y;
	}

}
