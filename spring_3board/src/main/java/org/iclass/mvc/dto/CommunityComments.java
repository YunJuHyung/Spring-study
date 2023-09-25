package org.iclass.mvc.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CommunityComments {

	private long idx;
	private long mref;
	private String wirter;
	private String content;
	private Timestamp createat;
	private String ip;
	private int heart; 
}
