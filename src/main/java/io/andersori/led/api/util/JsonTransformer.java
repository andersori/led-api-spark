package io.andersori.led.api.util;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import spark.ResponseTransformer;

@Component
public class JsonTransformer implements ResponseTransformer {

	@Override
	public String render(Object model) throws Exception {
		return new Gson().toJson(model);
	}
	
}
