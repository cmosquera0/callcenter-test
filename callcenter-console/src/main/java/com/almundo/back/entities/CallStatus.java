package com.almundo.back.entities;

/**
 * @author Carlos
 * @version 1.0
 * @created 12-sep.-2018 00:58:31
 */
public enum CallStatus {
	/**
	 * En espera
	 */
	OnHold,
	/**
	 * Atendida
	 */
	Served,
	/**
	 * Por transferir
	 */
	ToTransfer,
	/**
	 * Transferida
	 */
	Transferred;

	public Call m_Call;
}