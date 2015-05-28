/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import javax.ejb.EJBException;

class FachadaException extends EJBException {
    public FachadaException() {
    }
    public FachadaException(String message) {
        super(message);
    }
    public FachadaException(String message, Exception ex) {
        super(message, ex);
    }
}