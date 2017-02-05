package com.patterns.behavioral;

/**
 * Created by dbhattac on 2/5/2017.
 */

interface  BaseHandler
{
    void action();
}

class ConcreteHandler1 implements BaseHandler
{

    @Override
    public void action() {
        System.out.print("ConcreteHandler1 is executing..");
    }
}

class ConcreteHandler2 implements BaseHandler
{

    @Override
    public void action() {
        System.out.print("ConcreteHandler2 is executing..");
    }
}

class Request
{
    private Object type;
    public void setType(Object type)
    {
        this.type = type;
    }
    public Object getType()
    {
        return this.type;
    }
}


class HandlerDelegator
{
    public BaseHandler delegator(Request r)
    {
        if(r.getType() instanceof Integer)
        {
           return new ConcreteHandler1();
        }
        else
        {
            return new ConcreteHandler2();
        }
    }
}

public class ChainOfResponsibility {

    public static void main(String args[])
    {

        Request req = new Request();
        req.setType("1");

        BaseHandler bh =  new HandlerDelegator().delegator(req);
        bh.action();
    }

}
