package com.interview.video.utils;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JacksonUtils {

	public static final ObjectMapper MAPPER = new ObjectMapper();

	private JacksonUtils() {

	}

	public static String getJsonString(Object obj) throws JsonMappingException, IOException {
		String jsonInString = null;

		if (obj != null) {
			jsonInString = MAPPER.writeValueAsString(obj);
		}

		return jsonInString;
	}

	public static byte[] getBytes(Object obj) throws JsonProcessingException {
		return MAPPER.writeValueAsBytes(obj);
	}

	public static JsonNode getJson(String jsonString) throws JsonProcessingException, IOException {
		return MAPPER.readTree(jsonString);
	}

	// ****************************Old
	// methods*********************************************8
	public static Object getPOJO(Class<?> objectClass, String jsonString) throws JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		return mapper.readValue(jsonString, objectClass);
	}

	public static Map<String, Object> getMap(String jsonString) throws JsonMappingException, IOException {
		JsonFactory factory = new JsonFactory();
		factory.enable(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS);
		factory.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
		return MAPPER.readValue(jsonString, Map.class);
	}

	public static String getPOJO(Object value) throws JsonMappingException, IOException {
		return MAPPER.writeValueAsString(value);
	}

	public static Object getPOJO(Class objectClass, Map<String, Object> value)
			throws JsonMappingException, IOException {
		String string = MAPPER.writeValueAsString(value);
		return MAPPER.readValue(string, objectClass);
	}

	public static Map<String, Object> getMap(Object bean) {
		if (bean == null) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		return mapper.convertValue(bean, Map.class);
	}

	public static JsonNode getJsonNode(Object object) {
		return MAPPER.convertValue(object, JsonNode.class);
	}

	public static JsonNode getJsonNode(String str) {
		return MAPPER.convertValue(str, JsonNode.class);
	}

	public static JsonNode merge(JsonNode mainNode, JsonNode updateNode) {

		Iterator<String> fieldNames = updateNode.fieldNames();
		while (fieldNames.hasNext()) {

			String fieldName = fieldNames.next();
			JsonNode jsonNode = mainNode.get(fieldName);
			// if field exists and is an embedded object
			if (jsonNode != null && jsonNode.isObject()) {
				merge(jsonNode, updateNode.get(fieldName));
			} else {
				if (mainNode instanceof ObjectNode) {
					// Overwrite field
					JsonNode value = updateNode.get(fieldName);
					((ObjectNode) mainNode).put(fieldName, value);
				}
			}

		}

		return mainNode;
	}

	public static List<Object> getList(String jsonString) throws JsonParseException, JsonMappingException, IOException {
		return new ObjectMapper().readValue(jsonString, new TypeReference<List<Object>>() {
		});
	}
}
