FROM node:12-alpine as build

WORKDIR /app
COPY . /app/

RUN npm install
RUN npm run build

FROM nginx:alpine

COPY --from=build /app/build /usr/share/nginx/html
COPY ngnix/nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 3000
