package graph;

import java.security.InvalidParameterException;

import interfaces.Edge_IF;

public class Edge extends Edge_IF implements Comparable<Edge> {
	public Integer from;
	public Integer to;
	public Double weight;
	
	public Edge (int from, int to, Double weight) throws InvalidParameterException{
		if(weight < 0d) throw new InvalidParameterException("Podana waga nie może być ujemna");
		this.from = from;
		 this.to= to;
		 this.weight=weight;
	}
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (weight != null ? !weight.equals(edge.weight) : edge.weight != null) return false;
        if (from != null ? !from.equals(edge.from) : edge.from != null) return false;
        return !(to != null ? !to.equals(edge.to) : edge.to != null);

    }

    @Override
    public String toString() {
        return "Edge{" +
                "weight=" + weight + ", from=" + from + ", to=" + to +   '}';
    }

    @Override
    public int hashCode() {
        int result;
		if (weight != null)
			result = weight.hashCode();
		else
		result = 0;
        result = 11 * result + (from != null ? from.hashCode() : 0);
        result = 11 * result + (to != null ? to.hashCode() : 0);
        return result;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
        return (int) (this.weight - o.weight);

	}

	


	
}
