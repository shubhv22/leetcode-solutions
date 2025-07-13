class MyQueue {
private:
    stack<int> in, out;

    void trans() {
        while (!in.empty()) {
            out.push(in.top());
            in.pop();
        }
    }

public:
    MyQueue() {}

    void push(int x) {
        in.push(x);
    }

    int pop() {
        if (out.empty()) {
            trans();
        }
        int val = out.top();
        out.pop();
        return val;
    }

    int peek() {
        if (out.empty()) {
            trans();
        }
        return out.top();
    }

    bool empty() {
        return in.empty() && out.empty();
    }
};
