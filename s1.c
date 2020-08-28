#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<errno.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<arpa/inet.h>
#include<netinet/in.h>

void main()
{
	int n, fib0, fib1, fib2, ssock, csock;
	unsigned int len=sizeof(struct sockaddr_in);
	
	struct sockaddr_in server, client;

	ssock=socket(AF_INET, SOCK_STREAM, 0);
	
	if(ssock==-1)
	{
		perror("SOCKET IS NOT CONNECTED ! ");
		exit(-1);
	}

	server.sin_family=AF_INET;
        server.sin_port=htons(10000);
        server.sin_addr.s_addr=INADDR_ANY;

        bzero(&server.sin_zero, 0);

	if(bind(ssock, (struct sockaddr *)&server, len)==-1)
	{
		perror("BIND ! ");
		exit(-1);
	}

	if(listen(ssock, 5)==-1)
	{
		perror("LISTEN !");
		exit(-1);
	}
	
	csock=accept(ssock, (struct sockaddr *)&server, &len);

	if(csock==-1)
	{
		perror("ACCEPT !");
		exit(-1);
	}

	while(1)
	{
		recv(csock, &n, sizeof(n), 0);
		fib0=0; fib1=1;
		for(int i=0; i<=n; i++)
		{
			if(i<=1)
			{
				send(csock, &i, sizeof(i), 0);
			}
			else
			{
				fib2=fib1+fib0;
				send(csock, &fib2, sizeof(fib2), 0);
				fib0=fib1;
				fib1=fib2;
			}
		}
		printf("SENT FIBONACCI SERIES UPTO %d...\n", n);
	}
	close(ssock);
}
