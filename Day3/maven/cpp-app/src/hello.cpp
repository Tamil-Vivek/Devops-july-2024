#include "hello.h"

Hello::Hello() {
	cout << "Hello constructor ..." << endl;
}

Hello::~Hello() {
	cout << "Hello destructor ..." << endl;
}

void Hello::sayHello() {
	cout << "Hello C++ !" << endl;
}
