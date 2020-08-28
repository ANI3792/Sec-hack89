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
        int num, ssock, csock;
	char res[8];
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
		recv(csock, &num, sizeof(num), 0);
		if(num<=100 && num>=85)
		{
			strcpy(res, "Grade A");
		}
		else if(num<85 && num>=70)
                {
                       strcpy(res, "Grade B");
                }
		else if(num<70 && num>=60)
                {
                        strcpy(res, "Grade C");
                }
		else if(num<60 && num>=50)
                {
                        strcpy(res, "Grade D");
                }
		else if(num<50 && num>=0)
                {
                        strcpy(res, "Fail   ");
                }
		
		send(csock, &res, sizeof(res), 0);

		printf("Result for %d is %s\n", num, res);
        }
        close(ssock);
}
