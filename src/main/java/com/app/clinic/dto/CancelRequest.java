package com.app.clinic.dto;

import com.app.clinic.master.entity.CancelReason;
import com.app.clinic.master.entity.Status;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Apointment cancel request ")
public class CancelRequest {
	private Status status;
	private CancelReason cancelReason;
}