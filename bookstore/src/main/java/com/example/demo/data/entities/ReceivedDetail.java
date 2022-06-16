package com.example.demo.data.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "received_detail")
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "ReceivedDetail.findAll", query = "SELECT r FROM ReceivedDetail r")
    , @NamedQuery(name = "ReceivedDetail.findByReceivedId", query = "SELECT r FROM ReceivedDetail r WHERE r.receivedDetailPK.receivedId = :receivedId")})
public class ReceivedDetail {
	@EmbeddedId
    protected ReceivedDetailPK receivedDetailPK;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "unit_price")
    private long unitPrice;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Book book;
    @JoinColumn(name = "received_id", referencedColumnName = "received_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GoodsReceived goodsReceived;
    
    public ReceivedDetail() {
    	super();
    }

    public ReceivedDetail(ReceivedDetailPK receivedDetailPK) {
    	super();
        this.receivedDetailPK = receivedDetailPK;
    }

    public ReceivedDetail(ReceivedDetailPK receivedDetailPK, int quantity, long unitPrice) {
    	super();
        this.receivedDetailPK = receivedDetailPK;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public ReceivedDetail(int receivedId, int bookId) {
    	super();
        this.receivedDetailPK = new ReceivedDetailPK(receivedId, bookId);
    }
}
