package web.core

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature

class JsonMarshaller extends ObjectMapper {

    JsonMarshaller() {
        configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
    }
}
