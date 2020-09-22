package cz.tkacikd.customer_producer.domain;

public class CustomerCard {

    private Long id;
    private Long sum;
    private Long discount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "CustomerCard{" +
                "id=" + id +
                ", sum=" + sum +
                ", discount=" + discount +
                '}';
    }
}
