package com.example.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * HTMLのFORMから送るデータをマッピングするクラス
 * @author nagase
 */

@Data
public class CustomerForm {
	@NotNull //Annotation for Input check
	@Size(min=1, max=127)
	private String firstName;
	@NotNull //Annotation for Input check
	@Size(min=1, max=127)
	private String lastName;
	
}
