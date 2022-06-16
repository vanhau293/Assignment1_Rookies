package com.example.demo.data.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReceivedDetailPK {
	@Basic(optional = false)
    @Column(name = "received_id")
    private int receivedId;
    @Basic(optional = false)
    @Column(name = "book_id")
    private int bookId;

    public ReceivedDetailPK() {
    	super();
    }

    public ReceivedDetailPK(int receivedId, int bookId) {
    	super();
        this.receivedId = receivedId;
        this.bookId = bookId;
    }
}
