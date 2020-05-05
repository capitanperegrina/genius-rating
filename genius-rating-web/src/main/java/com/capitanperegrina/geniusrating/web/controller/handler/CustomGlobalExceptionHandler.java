package com.capitanperegrina.geniusrating.web.controller.handler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capitanperegrina.simpleuser.core.naming.SimpleUserMessagesNaming;
import com.capitanperegrina.simpleuser.web.RestResponseMessageLevels;
import com.capitanperegrina.simpleuser.web.ui.RestResponseUI;
import com.capitanperegrina.utils.exception.ServiceErrorException;
import com.capitanperegrina.utils.exception.ServiceException;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
    @ExceptionHandler(ServiceErrorException.class)
    @ResponseBody
    public ResponseEntity<RestResponseUI> handleServiceErrorException(ServiceErrorException e) throws IOException {
    	RestResponseUI ret = new RestResponseUI();
		ret.setMessageLevel(RestResponseMessageLevels.ERROR);
		ret.setMessageTitle(this.messageSource.getMessage(SimpleUserMessagesNaming.SIMPLE_USER_MESSAGE_TITLE, null, LocaleContextHolder.getLocale()));
		ret.setMessage(this.messageSource.getMessage(e.getMessage(), null, LocaleContextHolder.getLocale()));    	
		return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseEntity<RestResponseUI> handleServiceException(ServiceException e) throws IOException {
    	RestResponseUI ret = new RestResponseUI();
		ret.setMessageLevel(RestResponseMessageLevels.ERROR);
		ret.setMessageTitle(this.messageSource.getMessage(SimpleUserMessagesNaming.SIMPLE_USER_MESSAGE_TITLE, null, LocaleContextHolder.getLocale()));
		ret.setMessage(this.messageSource.getMessage(e.getMessage(), null, LocaleContextHolder.getLocale()));
		return new ResponseEntity<>(ret, HttpStatus.OK);
    }
    
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<RestResponseUI> handleRuntimeException(RuntimeException e) throws IOException {
    	RestResponseUI ret = new RestResponseUI();
		ret.setMessageLevel(RestResponseMessageLevels.ERROR);
		ret.setMessageTitle(this.messageSource.getMessage(SimpleUserMessagesNaming.SIMPLE_USER_MESSAGE_TITLE, null, LocaleContextHolder.getLocale()));
		ret.setMessage(this.messageSource.getMessage(SimpleUserMessagesNaming.SIMPLE_USER_RUNTIME_EXCEPTION, null, LocaleContextHolder.getLocale()));    	
		return new ResponseEntity<>(ret, HttpStatus.OK);
    }    
}