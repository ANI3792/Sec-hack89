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
	int n, fact=1, ssock, csock;
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
		perror("LISTEN ! ");
		exit(-1);
	}

	csock=accept(ssock, (struct sockaddr *)&server, &len);

	if(csock==-1)
	{
		perror("ACCEPT ! ");
		exit(-1);
	}

	while(1)
	{
		recv(csock, &n, sizeof(n), 0);

		fact=1;
		for(int i=1; i<=n; i++)
		{
			fact*=i;
		}

		send(csock, &fact, sizeof(fact), 0);

		printf("SENT FACTORIAL OF %d...\n", n);
	}

	close(ssock);
}
